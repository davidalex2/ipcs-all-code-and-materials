// routes/users.js
const express = require('express');
const router = express.Router();
const User = require('../model/User');


router.post('/' , async (req, res) => {
    try {
        const newUser = new User(req.body);
        const user = await newUser.save();
        res.status(201).json(user);
    } catch (err) {
        res.status(400).json({ error: err.message });
    }
});
router.get('/getall',async(req,res)=>{
    try{
        await User.find().then(user=>res.json(user));
    }catch(err){

        console.log(err);
    }
})
router.get('/get/:id' ,(req,res)=>{
    let uid=req.params.id;
    User.findById(uid).then(user=>{
         res.json(user)
    }
    );

})
router.put('/:id' ,(req,res)=>{
    let uid=req.params.id;
    User.findByIdAndUpdate(uid,req.body,{new:true})
    .then((user)=>
    {
        if(!user){
            res.status(404).json({error:"not found"})
        }else{
            res.json(user)
        }
    }
    ).catch(err=>console.log);

})
router.delete('/:id' , (req,res)=>{
    let uid=req.params.id;
    User.findByIdAndDelete(uid).then((user)=>{
        if(!user){
            res.json({user:'not found'})
        }else{
            res.json(user)
        }


    });
})

module.exports = router;
