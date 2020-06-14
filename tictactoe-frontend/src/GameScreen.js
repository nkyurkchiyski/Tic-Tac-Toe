class GameScreen extends React.Component {
    constructor(state) {
        this.state = state;
    }
    makeMove = async (move) => {
        const response = await fetch("http://localhost:8081/api/games", {
            method: "POST",
            cache: "no-cache",
            body: JSON.stringify({ move })
        });
        let game = await response.json();
        this.setState({
            gamePage: true,
            game: game,
            selectPage: false
        });
    }

    render() {
        return (
            <div>
            </div>
        );
    };
}


export default GameScreen;