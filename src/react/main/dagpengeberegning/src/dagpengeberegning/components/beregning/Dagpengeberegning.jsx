import React, { Component } from 'react'
import './dagpengeberegning.css';

class Dagpengeberegning extends Component {
    constructor(props){
        super(props);
        this.state = {
            status: null,
        }
    }
    
    handleClick = () => {

        const G = 101351;
        const max = 6*G;

        let sisteAar = parseFloat(document.getElementById("sisteAar").value, 10);
        sisteAar = (isNaN(sisteAar)) ? 0 : sisteAar;
        let nestSisteAar = parseFloat(document.getElementById("nestSisteAar").value, 10);
        nestSisteAar = (isNaN(nestSisteAar)) ? 0 : nestSisteAar;
        let nestNestSisteAar = parseFloat(document.getElementById("nestNestSisteAar").value, 10);
        nestNestSisteAar = (isNaN(nestNestSisteAar)) ? 0 : nestNestSisteAar;
        
        var krav = false;
        if (sisteAar > (1.5*G)){
            krav = true;
        } 
        const sum = sisteAar + nestSisteAar + nestNestSisteAar;
        if (sum > (3*G)){
            krav = true;
        }
    
        if (!krav){
            this.setState({status: <div className="statusText">Du har ikke krav på dagpenger.</div>});
            return;
        } 

        const average = sum / 3;
        const dagpenger = (Math.min(max, Math.max(sisteAar, average)) / 260).toFixed(0);

        const status = <div className="statusText">Du har krav på en dagsats på: <b>{dagpenger}</b> kr.</div>;
        this.setState({status: status});
    }

    render() {
        const aar = new Date().getFullYear();
        return (
            <div className="beregningContainer">
                <label htmlFor="sisteAar">Inntekt siste år:</label>
                <input id="sisteAar" type="number" placeholder="0"/>
                <label htmlFor="nestSisteAar">Inntekt for {aar - 1}:</label>
                <input id="nestSisteAar" type="number" placeholder="0"/>
                <label htmlFor="nestNestSisteAar">Inntekt for {aar - 2}:</label>
                <input id="nestNestSisteAar" type="number" placeholder="0"/>
                <button onClick={() => this.handleClick()}>Beregn</button>
                {this.state.status}
            </div>
        )
    }
}

export default Dagpengeberegning;
