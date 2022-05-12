import { LoginScreen } from './Screens/LoginScreen';
import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { AppStateProvider } from './Context/AppState';
import { appReducers } from './Context/Reducers';
import { initialState } from './Context';
import MainScreen from './Screens/MainScreen';

function App() {
  return (
    <React.StrictMode>
      <AppStateProvider reducer={appReducers} initialState={initialState}>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<LoginScreen/>}></Route>
            <Route path="/main" element={<MainScreen/>}></Route>
          </Routes>
        </BrowserRouter>
      </AppStateProvider>
    </React.StrictMode>

  );
}

export default App;
