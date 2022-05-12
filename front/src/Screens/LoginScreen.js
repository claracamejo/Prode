import { Button, TextField } from "@mui/material";
import { useAppState } from "../Context/AppState";
import background from '../assets/background.jpg';
import { useState } from "react";
import { authenticate } from "../Api/loginService";
import { saveUser } from "../Context/Actions/userActions";
import { useNavigate } from "react-router-dom";

const styles = {
    container: {
        backgroundImage: `url(${background})`,
        backgroundSize: 'cover',
        justifyContent: 'center',
        display: 'flex',
        height: '1000px',
        backgroundRepeat: 'no-repeat',
        alignItems: 'center',
        flexDirection: 'column',
        top: '0px',
        right: '0px',
        padding: 'opx'
    },
    textField: {
        backgroundColor: '#CAC2F5',
        color: 'white'
    },
    formContainer: {
        width: '700px',
        height: '200px',
        backgroundColor: '#2C159C',
        display: 'flex',
        flexDirection: 'column',
        padding: '20px',
        justifyContent: 'space-between'
    }
}

export const LoginScreen = () => {

    let navigate = useNavigate();
    const [state, dispatch] = useAppState();
    const [form, setForm] = useState({
        username: '',
        password: ''
    })

    const handleInput = (event) => {
        console.log(event.target.name)
        setForm({ ...form, [event.target.name]: event.target.value })
    }

    const submitLogin = () => {
        authenticate(form).then(response => {
            localStorage.setItem('token', response.data.jwttoken)
            dispatch(saveUser(form))
            navigate("/main")
        })
    }

    return (
        <div style={styles.container} maxWidth="xl">
            <div style={styles.formContainer}>
                <TextField onChange={handleInput} name="username" value={form.username} style={styles.textField} label="Username"></TextField>
                <TextField onChange={handleInput} name="password" value={form.lastname} style={styles.textField} label="Password" type="password"></TextField>
                <Button onClick={submitLogin}>Login</Button>
            </div>
        </div>
    )
}