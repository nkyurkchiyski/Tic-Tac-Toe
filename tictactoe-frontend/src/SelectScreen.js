class SelectScreen extends React.Component {
    constructor(state) {
        this.state = state;
    }
    createNewGame = async (piece) => {
        const response = await fetch("http://localhost:8081/api/games", {
            method: "GET",
            cache: "no-cache",
            body: JSON.stringify({ piece })
        });

        let game = await response.json();
        this.setState({
            gamePage: true,
            game: game,
            selectPage: false
        });
    };

    render() {
        return (
            <div>
                <h1>Welcome To TicTacToe</h1>
                <div class="container">
                    <div class="row">
                        <div class="col-md-6">
                            <button type="button" class="btn btn-primary btn-lg btn-block" onClick={this.createNewGame("O")}>
                                O
        </button>
                        </div>

                        <div class="col-md-6">
                            <button type="button" class="btn btn-primary btn-lg btn-block" onClick={this.createNewGame("X")}>
                                X
        </button>
                        </div>
                    </div>
                </div>
            </div>
        );
    };
}

export default SelectScreen;