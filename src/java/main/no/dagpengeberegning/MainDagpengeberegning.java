package no.dagpengeberegning;

import java.math.BigDecimal;
import java.math.BigInteger;
import static java.math.MathContext.DECIMAL64;
import static java.math.RoundingMode.CEILING;

import no.dagpengeberegning.util.Konstanter;

public class MainDagpengeberegning {

  public static int beregnDagpengeSats(int inntektSisteAar, int inntektNestSisteAar, int inntektNestNestSisteAar){
    return beregnDagpengeSats(BigInteger.valueOf(inntektSisteAar), BigInteger.valueOf(inntektNestSisteAar), BigInteger.valueOf(inntektNestNestSisteAar));
  }

  public static int beregnDagpengeSats(long inntektSisteAar, long inntektNestSisteAar, long inntektNestNestSisteAar){
    return beregnDagpengeSats(BigInteger.valueOf(inntektSisteAar), BigInteger.valueOf(inntektNestSisteAar), BigInteger.valueOf(inntektNestNestSisteAar));
  }

  public static int beregnDagpengeSats(BigInteger inntektSisteAar, BigInteger inntektNestSisteAar, BigInteger inntektNestNestSisteAar){
    if (inntektSisteAar.compareTo(BigInteger.ZERO) < 0){
      throw new IllegalArgumentException("Inntekt fra siste aar er negativ. Inntekt kan ikke vere negativ.");
    } else if (inntektNestSisteAar.compareTo(BigInteger.ZERO) < 0){
      throw new IllegalArgumentException("Inntekt fra nest siste aar er negativ. Inntekt kan ikke vere negativ.");
    } else if (inntektNestNestSisteAar.compareTo(BigInteger.ZERO) < 0){
      throw new IllegalArgumentException("Inntekt fra nest nest siste aar er negativ. Inntekt kan ikke vere negativ.");
    }

    BigInteger inntektSisteTreAArene = inntektSisteAar.add(inntektNestSisteAar).add(inntektNestNestSisteAar);
    if (harKravPaaDagpenger(inntektSisteAar, inntektSisteTreAArene)){
      return beregnDagpengesats(inntektSisteAar, inntektSisteTreAArene).intValue();
    }
    return 0;
  }

  /**
   * Regner ut om søker har krav på dagpenger. Søker har krav på dagpenger dersom én eller begge er oppfyllt:
   * 1. inntekt siste året (første param) er større enn 1.5 * grunnbeløpet,
   * 2. samlet inntekt tre siste årene er større enn 3 * grunnbeløpet.
   *
   * Dersom 1.5 * grunnbeløp har desimal (double), så rundes det ned til nærmeste heltall.
   * Dette introduserer en feilmargin på < 1 kr i fordel søker. Denne feilmarginen kan endres
   * dersom man implementerer denne klassen med BigDecimal over BigInteger.
   *
   * @param inntektSisteAAret inntekt siste året
   * @param inntektSisteTreAArene sum av inntekt siste tre årene
   * @return true dersom søker har krav på dagpenger, false ellers.
   */
  private static boolean harKravPaaDagpenger(BigInteger inntektSisteAAret, BigInteger inntektSisteTreAArene){
    return inntektSisteAAret.compareTo(BigInteger.valueOf((long) (1.5 * Konstanter.GRUNNBELOP))) > 0 || (inntektSisteTreAArene.compareTo(BigInteger.valueOf(3 * Konstanter.GRUNNBELOP)) > 0);
  }

  /**
   * Regner ut dagpengesats hvor grunnlaget er den høyeste av
   * 1. inntekt siste året,
   * 2. gjennomsnittelig inntekt siste tre årene
   *
   * Grunnlaget deles på definert antall dager i året for å finne dagpengesatsen.
   * Dagpengesatsen kan ikke være høyere enn 6G, altså 6 * grunnbeløp.
   *
   * @param inntektSisteAAret
   * @param inntektSisteTreAArene
   * @return Den laveste av (Grunnlag / antall dager i året) og 6 * grunnbeløp.
   */
  private static BigInteger beregnDagpengesats(BigInteger inntektSisteAAret, BigInteger inntektSisteTreAArene){
    // BigInteger har, imotsetning til BigDecimal, ikke noe mulighet for å velge hvilken vei divisjon skal runde av.
    // BigInteger vil derfor alltid runde nedover. For å få den til å runde opp, så kan vi addere 1 til resultatet.
    // Dette har den bi-effekten at dersom resultatet av divisjonen et nøyaktig heltall, så vil bruker få én krone
    // mer enn det personen egentlig har krav på. Bruker derfor BigDecimal til å gjøre divisjonen.

    BigDecimal grunnlag = new BigDecimal(inntektSisteAAret).max(new BigDecimal(inntektSisteTreAArene).divide(BigDecimal.valueOf(3), DECIMAL64));
    BigDecimal sats = grunnlag.divide(BigDecimal.valueOf(Konstanter.ANTALL_DAGER_I_ETT_AAR), 0, CEILING);
    return sats.toBigInteger().min(BigInteger.valueOf(Konstanter.HOYESTE_DAGPENGESATS));
  }

}
