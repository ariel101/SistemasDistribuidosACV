<?php

namespace App\Http\Controllers;

use App\Models\Login;
use Illuminate\Http\Request;
use App\Models\Usuario;
use Illuminate\Support\Facades\Hash;
use Firebase\JWT\JWT;
use Firebase\JWT\Key;

class LoginController extends Controller
{
    public function login(Request $request)
    {
        $input=$request->all();
        $usuario = Login::where('correo_electronico',$input['correo_electronico'])->first();
        if ($usuario == null) {
            return response()->json([
                'mensaje' => 'email invalido',
            ], 400);
        }
        //verificar usuarioy contraseña
        if (Hash::check($request->password, $usuario->password)) {
            $key = 'asdasd2##!!';
            $algorithm = 'HS256';
            $time = time();
            $payload = array(
                'iat' => $time, // Tiempo que inició el token
                'exp' => $time + 60*60, // Tiempo que expirará el token (+1 hora)
                'data' => [ // información del usuario
                    'user' => $usuario,
                ],
            );
            $jwt = JWT::encode($payload, $key, $algorithm);
            return response()->json([
                     'authorization' => [
                        'token' => $jwt,
                        'type' => 'bearer',
                        'expires' => $time ,
                    ],
            ], 200);
        } else {
            return response()->json([
                'mensaje' => 'Contraseña invalida',
            ], 400);
        }
    }
}
