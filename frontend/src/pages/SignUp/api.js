import http from "@/lib/http";
import axios from "axios";

export function signUp(body){
    return http.post('/api/v1/users', body);
}