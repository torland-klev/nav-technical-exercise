import React, {Component} from 'react';
import {Header, Body, Footer} from './components';
import './dagpengeberegning.css';

class DagpengeberegningView extends Component {
    render(){
        return(
            <div className="container">
                <Header />
                <Body />
                <Footer />
            </div>
        )
    }
}

export default DagpengeberegningView;