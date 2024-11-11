import logo from './logo.svg';
import './App.css';
import CustomerAdd from './CustomerAdd';
import CustomerView from './CustomerView';
import { Provider } from 'react-redux';
import { store } from './Store';

function App() {
  return (
    <Provider store={store}>
        <div className="App">
            <h1>React Redux customer Example</h1>
            <CustomerAdd/>
            <CustomerView/>
        </div>
    </Provider>
  );
}

export default App;
