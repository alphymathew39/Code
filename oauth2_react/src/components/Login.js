import { React } from 'react';
import { Link } from 'react-router-dom';
import { generateCodeChallenge, generateCodeVerifier } from '../pkce/pkce';
const Login = () => {
    const verifier = generateCodeVerifier();
    sessionStorage.setItem('codeVerifier', verifier);
    const codeChallenge = generateCodeChallenge();
    sessionStorage.setItem('codeChallenge', codeChallenge);
console.log("1"+verifier)
console.log("2"+codeChallenge)
    return (
        <>
            <Link to={'/redirect'}>Login</Link>
        </>
    );
}

export default Login;