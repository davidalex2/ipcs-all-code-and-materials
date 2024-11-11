const express = require('express');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');
const jwtrouter = express.Router();
const verifyToken = require('./VerifyToken')

const crypto = require('crypto');
const secretKey = 'my-secret-key';
const Credential = require('../model/Credential');

jwtrouter.post('/register', async (req, res) => {
    try {
        let { uname, pwd } = req.body;
        let encrypt = await bcrypt.hash(pwd, 10);
        let u_p = new Credential({ uname, pwd: encrypt });

        await u_p.save();

        res.status(201).json({ message: "User registered successfully" });
    } catch (err) {
        res.status(500).json({ error: `${err}` });
    }
});

jwtrouter.post('/login', async (req, res) => {
    try {
        let { uname, pwd } = req.body;

        let user = await Credential.findOne({ uname });

        if (!user) {
            return res.status(401).json({ error: "Invalid username" });
        }

        let passMatch = await bcrypt.compare(pwd, user.pwd);

        if (!passMatch) {
            return res.status(401).json({ error: "Invalid password" });
        }

        let jwt_token = jwt.sign({ uname: user.uname }, secretKey, { expiresIn: '1h' });

        res.status(200).json({ token: jwt_token });
    } catch (err) {
        res.status(500).json({ error: `${err}` });
    }
});
jwtrouter.get('/verify', verifyToken, (req, res) => {
    res.json({ user: 'verified' });
})

module.exports = jwtrouter;
