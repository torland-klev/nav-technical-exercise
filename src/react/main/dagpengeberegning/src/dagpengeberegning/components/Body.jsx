import React, {Component} from 'react';
import './components.css';
import ContentBox from './ContentBox';
import {DownwardButton} from './downwardbutton';
import {Dagpengeberegning} from './beregning';

class Body extends Component{

    render(){

        const dagpengeLink = "https://www.nav.no/no/person/arbeid/dagpenger-ved-arbeidsloshet-og-permittering/dagpenger";
        
        // For å legge til flere elements i body, lag en ny ContentBox og legg childrens inn i den.
        return(
            <div className="shared body">
              <ContentBox style={{backgroundColor: "#FFE9CC", border: "2px solid #D87F0A"}}>
                <div className="text">
                  Utregning av dagpenger i denne modulen er meget forenklet fra
                  NAV sine gjeldende rettningslinjer. Det anbefales at du besøker
                  NAV's egne sider for å få en bedre oversikt over de faktiske 
                  reglene for dagpenger.
                  For å lese mer om dagpenger, kan du klikke <a href={dagpengeLink}>her.</a>
                </div>
                </ContentBox>
              <ContentBox>
                <div className="text">
                    <h2>Beregning av dagpenger</h2>
                    For å ha krav på dagpenger, så må du ha enten:
                    <ul>
                        <li>tjent over 1.5G over forrige kalenderår, eller </li>
                        <li>tjent tilsammen over 3G de siste tre kalenderårene.</li>
                    </ul>
                    Grunnbeløpet, kalt G, brukes til å beregne mange av NAVs ytelser. 
                    Grunnbeløpet justeres 1. mai hvert år og blir fastsatt etter trygdeoppgjøret,
                    og er per 1. mai 2020 på kr 101 351.
                    <br />
                    <br />
                    Dersom du har krav på dagpenger, så vil det utregnes et dagepengegrunnlag. Dette
                    grunnlaget er den høyeste av inntekten siste året, og gjennomsnittelig inntekt
                    siste tre årene. Grunnlaget vil så deles på antall arbeidsdager i ett år, som
                    NAV har definert til å være 260. Dette resultatet vil være dagpengesatsen din.
                    Vær oppmerksom på at dagpengegrunnlaget kan ikke være høyere en 6G.
                </div> 
                
                <DownwardButton style={{marginTop: "20px"}}>   
                    <Dagpengeberegning />
                </DownwardButton>
              </ContentBox>
            </div>
        )
    }
    
}

export default Body;