const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const jwtRoutes = require('./route/JWTex');

require('dotenv').config();

const app = express();
const port = 1000;

app.use(bodyParser.json());

app.use((req, res, next) => {
    const token = req.header('Authorization')?.replace('Bearer ', '');
    if (token) {
      try {
        const decoded = jwt.verify(token, secretKey);
        req.user = decoded;
      } catch (error) {
        return res.status(401).send('Invalid token');
      }
    }
    next();
  });

mongoose.connect('mongodb://localhost:27017/user_db', {}).then(() => {
    console.log('MongoDB connected successfully');
}).catch((err) => {
    console.error('MongoDB connection error:', err);
    process.exit(1); 
});

app.use('/auth', jwtRoutes);

app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});