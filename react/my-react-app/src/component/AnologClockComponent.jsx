import React, { useState, useEffect } from 'react';
import './css/Analog.css';

function AnalogClock() {
  const [hour, setHour] = useState(0);
  const [minute, setMinute] = useState(0);
  const [second, setSecond] = useState(0);

  useEffect(() => {
    const intervalId = setInterval(() => {
      const currentTime = new Date();
      const hourAngle = (currentTime.getHours() % 12 + currentTime.getMinutes() / 60) * 30;
      const minuteAngle = currentTime.getMinutes() * 6;
      const secondAngle = currentTime.getSeconds() * 6;

      setHour(hourAngle);
      setMinute(minuteAngle);
      setSecond(secondAngle);
    }, 1000);

    return () => clearInterval(intervalId);
  }, []);

  return (
    <div className="clock-face">
      <div
        className="hour-hand"
        style={{
          transform: `rotate(${hour}deg)`,
        }}
      />
      <div
        className="minute-hand"
        style={{
          transform: `rotate(${minute}deg)`,
        }}
      />
      <div
        className="second-hand"
        style={{
          transform: `rotate(${second}deg)`,
        }}
      />
    </div>
  );
}

export default AnalogClock;