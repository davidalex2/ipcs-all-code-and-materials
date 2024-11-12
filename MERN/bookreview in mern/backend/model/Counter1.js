let mongoose=require('mongoose');

let idCounter=new mongoose.Schema({
    model:{type:String,required:true,unique:true},
    seq:{type:Number,default:0}
})
module.exports=mongoose.model('Counter',idCounter);