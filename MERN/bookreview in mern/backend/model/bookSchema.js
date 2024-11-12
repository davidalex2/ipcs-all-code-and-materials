const mongoose = require('mongoose');
const Counter=require('./Counter1');

const reviewSchema = new mongoose.Schema({
    user: { type: String, required: true },
    rating: { type: Number, required: true },
    comment: { type: String, required: true },
});

const bookSchema = new mongoose.Schema({
    _id:{type:Number,required:true,default:0},
    title: { type: String, required: true },
    author: { type: String, required: true },
    reviews: [reviewSchema],
});

bookSchema.pre('save',async function(next){
    if(this.isNew){
        try{
            let counter=await Counter.findOneAndUpdate(
                {model:'Book'},
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


const Book = mongoose.model('Book', bookSchema);

module.exports = Book;