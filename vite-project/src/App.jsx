import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [id, setId] = useState('');
  const [password, setPassword] = useState('');
  
  const handleSubmit = (event) => {
    event.preventDefault(); // Prevent the default form submission behavior

    // Make a POST request with the form data
    axios.post('/api/login', {
      id: id,
      password: password
    })
    .then(response => {
      alert('성공!');
    })
    .catch(error => {
      alert('실패!');
    });
  };


  return (
    <>
      <div>
      <form onSubmit={handleSubmit}>
          <input 
            type="text" 
            placeholder="id" 
            value={id} 
            onChange={(e) => setId(e.target.value)} // Update id state on input change
          />
          <input 
            type="password" 
            placeholder="pw" 
            value={password} 
            onChange={(e) => setPassword(e.target.value)} // Update password state on input change
          />
          <input type="submit" value="Login" />
        </form>
      </div>
    </>
  );
}

export default App;
