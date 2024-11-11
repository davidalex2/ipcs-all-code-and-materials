// models/User.js
const mongoose = require('mongoose');
const counter=require('./Counter');
const Counter = require('./Counter');

const userSchema = new mongoose.Schema({
    _id:{type:Number,required:true,default:0},
    name: { type: String, required: true },
    email: { type: String, required: true, unique: true },
    createdAt: { type: Date, default: Date.now }
});
userSchema.pre('save',async function(next){
    if(this.isNew){
        try{
            let counter=await Counter.findOneAndUpdate(
                {model:'User'},
                {$inc:{seq:1}},
                {new:true,upsert:true}
            );
            this._id=counter.seq;
        }catch(err){
            return next(err);
        }
    }
    next();
})

module.exports = mongoose.model('User', userSchema);
