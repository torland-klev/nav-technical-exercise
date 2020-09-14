import React, {Component} from 'react';
import { CSSTransitionGroup } from 'react-transition-group'
import './downwardbutton.css';

class DownwardButton extends Component {

    constructor(props){
        super(props);
        this.style = {
            border: "2px solid black",
            paddingLeft: "5px",
            paddingRight: "5px",
            cursor: "pointer",
            height: "fit-content",
            width: "fit-content",
        };
        this.state = {
            visible: false,
        };
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick = () => {
        this.setState({ visible: !this.state.visible });
    }

    render(){
        const buttonText = (this.state.visible) ? "\u1403" : "\u1401";
        return(
            <div style={{paddingTop: "5px", display: "flex", alignItems:"center", flexDirection: "column"}}>
                <CSSTransitionGroup 
                    transitionName="example"
                    transitionEnterTimeout={50}
                    transitionLeaveTimeout={50}>
                    {this.state.visible ? this.props.children : null}
                </CSSTransitionGroup>
                <div style={{...this.style, ...this.props.style}}>
                    <div className="animatedGradient" onClick={() => this.handleClick()}>	
                        {buttonText}
                    </div>
                </div>
            </div>
        )
    }
}

export default DownwardButton;