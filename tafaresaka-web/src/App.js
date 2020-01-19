import React, { Component } from 'react';
import { HashRouter, Route, Switch, Redirect } from 'react-router-dom';
import { createBrowserHistory } from 'history'
import 'react-toastify/dist/ReactToastify.css';
import './App.scss';

const loading = () => <div className="animated fadeIn pt-3 text-center">Loading...</div>;

// Core Containers
const AnonLayout = React.lazy(() => import('./containers/Core/AnonLayout/AnonLayout'));
const GenericHomeLayout = React.lazy(() => import('./containers/Core/GenericHomeLayout/GenericHomeLayout'));

// history
export const browserHistory = createBrowserHistory();

/**
 * 
 * This is the first component displayed in the application.
 * 
 * Following pages are public (not auth required): login, register, lostpass,404,500.
 * 
 * Other pages are private
 */
class App extends Component {

  render() {
    return (
      <HashRouter history={browserHistory}>
          <React.Suspense fallback={loading()}>
            <Switch>
            	<Route path="/home" name="Accueil" component={GenericHomeLayout} />
            	<Route path="/home/lostPass" name="Anon pages" component={AnonLayout} />
            	<Route path="/home/admin" name="Admin" component={GenericHomeLayout} />
            	<Route path="/home/desktop" name="Demo desktop" component={GenericHomeLayout} />
            	<Route path="/home/mobile" name="Demo mobile" component={GenericHomeLayout} />
            	<Route path="/home/profile/:accountId" name="Demo profile" component={GenericHomeLayout} />
            	<Route path="*" name="Unkown" component={AnonLayout} />
            </Switch>
          </React.Suspense>
      </HashRouter>
    );
  }
}

export default App;

