var ELiquid;
let app;
ELiquid = false;
app = 123;
let isOpen=true;
const pi=3.14;

function displayWord(name){
    const word = 'Hello, '+ name;
    console.log(word);
}
displayWord('Danil');

function displayWord(name, sal='Hello'){
    console.log(`${sal}, ${name}`);
}
displayWord(`Danil`, `Hello`);
