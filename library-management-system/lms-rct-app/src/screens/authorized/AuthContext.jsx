import { useContext, createContext, useState } from "react";


export const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
  console.log('hello');
  const [username, setUsername] = useState('');
  const [role, setRole] = useState('');
  
  const loginAction = (data) => {
    
  };

  const logOut = () => {
    setUser(null);
    setToken("");
    navigate("/login");
  };

  return (
    <AuthContext.Provider value={{ username, setUsername, role, setRole, loginAction, logOut }}>
      {children}
    </AuthContext.Provider>
  );

};

export default AuthProvider;

export const useAuth = () => {
  return useContext(AuthContext);
};