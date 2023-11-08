<?php

namespace App\Http\Controllers;

use App\Models\Factura;
use Illuminate\Http\Request;

class FacturaController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
        return Factura::all();
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
            $factura = Factura::create($input);
            return $factura;
        }
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
        $factura = Factura::find($id);
        if ($factura == null) {
            return response()->json([

                'mensaje' => 'No se encontro a la agenda'
            ], 404);
        }
        return $factura;
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
        $input = $request->all();
        $factura = Factura::find($id);
        if ($factura == null) {
            return response()->json([

                'mensaje' => 'No se encontro a la agenda'
            ], 404);
        }
        $factura->update($input);
        return $factura;
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
        $factura = Factura::find($id);
        if ($factura == null) {
            return response()->json([

                'mensaje' => 'No se encontro a la agenda'
            ], 404);
        }
        $factura->delete();
        return $factura;
    }
}
