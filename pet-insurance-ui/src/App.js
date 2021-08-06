import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Link, Route, Switch } from 'react-router-dom';
import Header from './components/Header/Header';
import PetTable from './components/PetTable/PetTable';
import ManagePets from './components/ManagePets/ManagePets';
import PetStore from './store/PetStore';
import {Provider} from "react-redux";
import OwnerTable from "./components/OwnerTable/OwnerTable";
import AddOwner from "./components/AddOwner/AddOwner";

function App() {
  return (
      <div className="App">
          <Provider store={PetStore}>
              <BrowserRouter>
                  <Header> </Header>
                  <Switch>

                      <Route path={["/pet"]}> <PetTable/></Route>
                      <Route path={["/addPet"]}> <ManagePets/></Route>
                      <Route path={["/"]} exact> <OwnerTable/></Route>
                      <Route path={["/addOwner"]}> <AddOwner/></Route>

                  </Switch>
              </BrowserRouter>
          </Provider>
      </div>
  );
}

export default App;
