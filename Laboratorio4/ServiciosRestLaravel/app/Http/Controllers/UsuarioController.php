<?php

namespace App\Http\Controllers;

use App\Models\Usuario;
use Illuminate\Http\Request;

class UsuarioController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
        return Usuario::all();
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
        $usuario = $request->attributes->get('factura');
        $nivel = $usuario->usuario->nivel;
        if($nivel ==1){
            $input = $request->all();
            $usu = Usuario::create($input);
            return $usu;
        }
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
        $usu = Usuario::find($id);
        if ($usu == null) {
            return response()->json([

                'mensaje' => 'No se encontro a la agenda'
            ], 404);
        }
        return $usu;
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
        $input = $request->all();
        $usu = Usuario::find($id);
        if ($usu == null) {
            return response()->json([

                'mensaje' => 'No se encontro a la agenda'
            ], 404);
        }
        $usu->update($input);
        return $usu;
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
        $usu = Usuario::find($id);
        if ($usu == null) {
            return response()->json([

                'mensaje' => 'No se encontro a la agenda'
            ], 404);
        }
        $usu->delete();
        return $usu;
    }
}
