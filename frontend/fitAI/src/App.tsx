import { useState } from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import RegisterPage from "./pages/RegisterPage.tsx";
import LoginPage from "./pages/LoginPage.tsx";
function App() {

  return (
    <Router>
       <Routes>
        <Route path="/register" element={<RegisterPage/>}/>
        <Route path="/login" element={<LoginPage/>}/>
      </Routes> 
    </Router>
  )
}

export default App
