class WelcomeScreen extends React.Component {
    constructor(state) {
        this.state = state;
    }

    selectGamePiece = () => {
        this.setState({
            gamePage: false,
            game: null,
            selectPage: true
        });
    }

    render() {
        return (
            <div>
                <h1>Welcome To TicTacToe</h1>
                <div class="container">
                    <div class="row">
                        <div class="col-md">
                            <button type="button" class="btn btn-primary btn-lg btn-block" onClick={this.selectGamePiece}>
                                Start New Game
          </button>
                        </div>
                    </div>
                </div>
            </div>
        );
    };
}


export default WelcomeScreen;