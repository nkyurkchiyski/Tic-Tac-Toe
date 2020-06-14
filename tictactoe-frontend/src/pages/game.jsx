import React, { useState } from 'react';

const GamePage = () => {
    const [game, setGame] = useState({ game: {} });
    const api = "/api/game";

    const getSelected = () => {
        let e = document.getElementById("pieceSelect");
        let piece = e.options[e.selectedIndex].value;

        e = document.getElementById("difficultySelect");
        let difficulty = e.options[e.selectedIndex].value;
        return { difficulty, piece };
    };

    const handleResponse = response => {
        if (response.code == 400) {
            document.getElementById("errorMessage").innerText = response.responseObject.message;
            document.getElementById("alertBox").classList.remove("d-none");
        } else {
            setGame(response.responseObject);
        }
    };

    const getWinner = winner => {
        if (!winner) {
            return "Draw";
        } else if (String(winner).toLocaleLowerCase() === "x") {
            return "The Winner is X";
        } else {
            return "The Winner is O";
        }
    };

    const createNewGame = async newGame => {
        await fetch(`${api}/new`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                'Accept': 'application/json',
                "Access-Control-Allow-Origin": "*"
            },
            cache: "no-cache",
            body: JSON.stringify(newGame)
        })
            .then(response => response.json())
            .then(res => handleResponse(res));
    };

    const makeMove = async move => {
        await fetch(api, {
            method: "POST",
            cache: "no-cache",
            headers: {
                "Content-Type": "application/json",
                'Accept': 'application/json',
                "Access-Control-Allow-Origin": "*"
            },
            body: JSON.stringify(move)
        })
            .then(response => response.json())
            .then(res => handleResponse(res));
    }
    return (!game.id ? (
        <div className="App mt-2 container">
            <div className="p-5 main-content shadow">
                <h2>Start New Game</h2>
                <div className="alert alert-danger d-none" id="alertBox" role="alert">
                    <strong>Error! </strong><span id="errorMessage"> </span>
  <button type="button" className="close" onClick={()=>{ document.getElementById("alertBox").classList.add("d-none")}} aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <br />
                <div>
                    <div className="form-group">
                        <h6 htmlFor="difficultySelect" className="text-left">Difficulty</h6>
                        <select className="form-control" id="difficultySelect">
                            <option value="easy">Easy</option>
                            <option value="medium">Medium</option>
                            <option value="hard">Hard</option>
                        </select>
                    </div>
                    <div className="form-group">
                        <h6 htmlFor="pieceSelect" className="text-left">Piece</h6>
                        <select className="form-control" id="pieceSelect">
                            <option value="o">O</option>
                            <option value="x">X</option>
                        </select>
                    </div>
                    <button className="btn btn-primary btn-lg btn-block" onClick={() => createNewGame(getSelected())}>
                        New Game
</button>
                </div>
            </div>
        </div>
    ) : (
            <div className="App my-2 container">
                <div className="p-5 main-content shadow">
                    {game.finished ? <h2>{getWinner(game.winner)}</h2> : <h2>Make your move</h2>}
                    <div className="alert alert-danger d-none" id="alertBox" role="alert">
                    <strong>Error! </strong><span id="errorMessage"> </span>
  <button type="button" className="close" onClick={()=>{ document.getElementById("alertBox").classList.add("d-none")}} aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                    <br />
                    <button className="btn btn-primary" onClick={() => setGame({})}>
                        New Game</button>
                    <br />
                    <br />
                    <div className="container">
                        <div className="row no-gutters">
                            {game.pieces.map((piece, index) => {
                                return <div key={index} className="col-md-4">
                                    <div className={piece ? (piece === "X" ? "card p-5 bg-primary" : "card p-5 bg-danger") : "card p-5"} onClick={!game.pieces[index] ? () => makeMove({ gameId: game.id, index: index }) : undefined}><span className="piece">{piece ? piece : undefined}&nbsp;</span>
                                    </div>
                                </div>
                            })}
                        </div>
                    </div>
                </div>
            </div>
        )
    );
};

export default GamePage;