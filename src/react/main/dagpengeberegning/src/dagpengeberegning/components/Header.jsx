import React, {Component} from 'react';
import './components.css';

class Header extends Component{

    render(){
        return(
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