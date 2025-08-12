import axios from "axios";
export class ApiService {  

    static  getBooks = () => {
        return axios.get('/api/books');
    }
}