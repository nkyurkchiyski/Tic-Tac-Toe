import React from "react";
import { Link } from "react-router-dom";

const MainPage = () => {
    return (
        <div className="App mt-2 container">
            <div className="p-5 main-content shadow">
                <h2>Welcome To TicTacToe</h2>
                <br />
                <div className="container">
                    <div className="row">
                        <div className="col-md">
                            <Link to="/game" className="btn btn-primary btn-lg btn-block">Start New Game</Link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default MainPage;