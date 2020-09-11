package no.dagpengeberegning.util;

public class Konstanter {
    public static final int GRUNNBELOP = 101351;
    public static final int ANTALL_DAGER_I_ETT_AAR = 260;
    public static final int HOYESTE_DAGPENGEGRUNNLAG = GRUNNBELOP * 6;
    // Deler høyeste dagpengegrunnlag på 260 og runder opp, ettersom det er krav at dagpengesats skal rundes opp.
    public static final int HOYESTE_DAGPENGESATS = (int) Math.ceil((double) HOYESTE_DAGPENGEGRUNNLAG / 260);
}
