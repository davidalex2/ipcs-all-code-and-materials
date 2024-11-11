// app.js
const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');
const userRoutes = require('./routes/users');

require('dotenv').config();

const app = express();
const port = 1024;

// Middleware
app.use(bodyParser.json());


mongoose.connect('mongodb://localhost:27017/user_db', {}).then(() => {
    console.log('MongoDB connected successfully');
}).catch((err) => {
    console.error('MongoDB connection error:', err);
    process.exit(1);
});

app.use('/api/users', userRoutes);

app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});
