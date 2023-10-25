import React, { useState } from 'react';
import './SignIn.css';
import '//SignIn.php';
const SignIn = () => {
  const [formData, setFormData] = useState({
    patientName: '',
    age: '',
    gender: '',
    telephone: '',
    address: '',
    email: '',
  });
  const [message, setMessage] = useState(''); // Initialize message state

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    fetch('http://localhost/SignIn.php', {
      method: 'POST',
      body: new URLSearchParams(formData).toString(),
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data); // Add this line to inspect the response
        if (data.success) {
          setMessage(data.message);
        } else {
          setMessage(data.message);
        }
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  };

  return (
    <div className="signin-container">
      <h2>Patient Sign In</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Patient Name</label>
          <input
            type="text"
            name="patientName"
            value={formData.patientName}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Age</label>
          <input
            type="number"
            name="age"
            value={formData.age}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Gender</label>
          <input
            type="text"
            name="gender"
            value={formData.gender}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Telephone Number</label>
          <input
            type="tel"
            name="telephone"
            value={formData.telephone}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Address</label>
          <input
            type="text"
            name="address"
            value={formData.address}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Email</label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
          />
        </div>
        <input type="hidden" name="submit_button" value="1" />
        <button type="submit">Sign In</button>
        {message && <p>{message}</p>}
      </form>
    </div>
  );
};

export default SignIn;
