// middleware/authorize.js
function authorize(requiredRoles) {
    return (req, res, next) => {
      const user = req.user; // Assume user is already attached to req
      if (!user) {
        return res.status(401).send('User not authenticated');
      }
      if (!requiredRoles.includes(user.role)) {
        return res.status(403).send('Access denied');
      }
      next();
    };
  }
  
  module.exports = authorize;
  