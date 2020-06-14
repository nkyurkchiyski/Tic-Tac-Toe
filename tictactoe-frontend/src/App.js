import React, { Component } from "react";
import "./App.css";
import {
  BrowserRouter as Router,
  Route,
  Switch,
  Redirect
} from "react-router-dom";

import MainPage from "./pages/index";
import GamePage from "./pages/game";  
import NotFoundPage from "./pages/404"; 

class App extends Component {
  render() {
    return (
      <Router>
      <Switch>
      <Route exact path="/" component={MainPage} />
      <Route exact path="/game" component={GamePage} />
      <Route exact path="/404" component={NotFoundPage} />
      <Redirect to="/404" /> 
      </Switch>
      </Router>
    );
  }
}

export default App;