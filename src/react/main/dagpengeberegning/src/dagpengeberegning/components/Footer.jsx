import React, {Component} from 'react';
import './components.css';

class Footer extends Component{

    render(){
        return(
            <div className="shared footer">
                <div className="content">
                    <div className="element">
                        <img src="logo192.png" alt="logo" width="50px"/>
                        <div className="text">Kodeppgave utført for NAV</div>
                        <div className="text">Høst 2020</div>
                    </div>
                    <div className="element">
                        <div className="text">Kontakt:</div>
                        <div className="text">Henrik Torland Klev</div>
                        <div className="text">482 80 945</div>
                        <a href="mailto:klevhenrik@gmail.com">klevhenrik@gmail.com</a>
                    </div>
                </div>
            </div>
        )
    }
    
}

export default Footer;