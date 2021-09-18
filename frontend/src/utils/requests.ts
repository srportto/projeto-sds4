export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? 'http://localhost:8080';
/* 
  ?? -> Eh um operador de validacao de nulidade, caso a variavel REACT_APP_BACKEND_URL não exista no ambiente
     passa-se o valor a direita de "??" , no caso: http://localhost:8080"

     Esse hack permite roda a aplicação local e no netlify
*/