<?php

namespace App\Http\Controllers;

use App\Models\Cliente;
use Illuminate\Http\Request;

class ClienteController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
        return Cliente::all();
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
        $input = $request->all();
        $cliente = Cliente::create($input);
        return $cliente;
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
        $cliente = Cliente::find($id);
        if ($cliente == null) {
            return response()->json([

                'mensaje' => 'No se encontro el pronostico'
            ], 404);
        }
        return $cliente;
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
        $input = $request->all();
        $cliente = Cliente::find($id);
        if ($cliente == null) {
            return response()->json([

                'mensaje' => 'No se encontro el pronostico'
            ], 404);
        }
        $cliente->update($input);
        return $cliente;
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
        $cliente = Cliente::find($id);
        if ($cliente == null) {
            return response()->json([

                'mensaje' => 'No se encontro el pronostico'
            ], 404);
        }
        $cliente->delete();
        return $cliente;
    }
}
