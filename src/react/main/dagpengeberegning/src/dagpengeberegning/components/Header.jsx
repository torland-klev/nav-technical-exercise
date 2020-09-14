import React, {Component} from 'react';
import {isMobile} from 'react-device-detect';
import './components.css';

class Header extends Component{


    render(){
        return ((isMobile) ?
            
            <div className="shared header">
                <div className="content">
                    <div className="textMobile">Dagpengekalkulator</div>
                    <img src="headerImage.png" alt="Wondering cartoon man" width="50px"/> 
                </div>
            </div>
            :
            
            <div className="shared header">
                <div className="content">
                    <div className="text">Dagpengekalkulator</div>
                    <img src="headerImage.png" alt="Wondering cartoon man" width="150px"/>
                </div>
            </div>
        )
    }
}

export default Header;