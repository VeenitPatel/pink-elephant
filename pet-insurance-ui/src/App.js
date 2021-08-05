import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Link, Route, Switch } from 'react-router-dom';
import Header from './components/Header/Header';
import PetTable from './components/PetTable/PetTable';
import ManagePets from './components/ManagePets/ManagePets';

function App() {
  return (
    <BrowserRouter>
      <Header> </Header>
      <Switch>
        <Route path={["/pet"]}> <PetTable/></Route>
        <Route path={["/addPet"]}> <ManagePets/></Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
