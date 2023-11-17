<?php

namespace App\Http\Controllers;

use App\Models\Cuenta;
use Illuminate\Http\Request;

class CuentaController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
        $input = $request->all();
        $cuenta = Cuenta::create($input);
        return $cuenta;
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
        $cuenta = Cuenta::find($id);
        if ($cuenta == null) {
            return response()->json([

                'mensaje' => 'No se encontro la cuenta'
            ], 404);
        }
        return $cuenta;
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
        $input = $request->all();
        $cuenta = Cuenta::find($id);
        if ($cuenta == null) {
            return response()->json([

                'mensaje' => 'No se encontro la cuenta'
            ], 404);
        }
        $cuenta->update($input);
        return $cuenta;
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
        $cuenta = Cuenta::find($id);
        if ($cuenta == null) {
            return response()->json([

                'mensaje' => 'No se encontro la cuenta'
            ], 404);
        }
        $cuenta->delete();
        return $cuenta;
    }
}
