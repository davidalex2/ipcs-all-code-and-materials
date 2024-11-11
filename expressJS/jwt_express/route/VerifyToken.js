const crypto = require('crypto');
const secretKey='my-secret-key';

function checkToken(req, res, next) {
    let token = req.headers['x-auth-token']; // Access headers correctly

    if (!token) {
        return res.status(401).json({ error: "Token not provided" });
    }

    try {
        let decoded = jwt.verify(token, secretKey);
        req.user = decoded.user; // Attach decoded user information to request object
        next(); // Move to the next middleware or route handler
    } catch (err) {
        console.error('Token verification error:', err);
        return res.status(500).json({ error: `Token verification failed: ${err.message}` });
    }
}
module.exports=checkToken;