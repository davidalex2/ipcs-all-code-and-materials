const nodemailer = require('nodemailer');

class EmailService {
  async sendEmail(mymail,to, subject, body) {
    try {
      // Create a transporter object
      let transporter = nodemailer.createTransport({
        host: 'smtp.example.com',
        port: 587,
        secure: false, // or 'STARTTLS'
        auth: {
          user: 'username',
          pass: 'password'
        }
      });

      // Define the email
      let mailOptions = {
        from: mymail,
        to: to,
        subject: subject,
        text: body
      };

      // Send the email
      let info = await transporter.sendMail(mailOptions);

      console.log('Email sent: ' + info.response);
    } catch (error) {
      console.log('Error sending email: ' + error);
    }
  }
}

module.exports = EmailService;