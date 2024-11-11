const mydb=require('mongoose');
const credentialShema=new mydb.Schema({
    uname:{type:String,required:true},
    pwd:{type:String,required:true}
})
let Credential=mydb.model('Credential',credentialShema);

module.exports=Credential;