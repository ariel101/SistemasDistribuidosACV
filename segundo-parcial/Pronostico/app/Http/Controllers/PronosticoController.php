<?php

namespace App\Http\Controllers;

use App\Models\Pronostio;
use Illuminate\Http\Request;

class PronosticoController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
        return Pronostio::all();
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
        $input = $request->all();
        $pron = Pronostio::create($input);
        return $pron;
        
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
        $pron = Pronostio::find($id);
        if ($pron == null) {
            return response()->json([

                'mensaje' => 'No se encontro el pronostico'
            ], 404);
        }
        return $pron;
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
        $input = $request->all();
        $pron = Pronostio::find($id);
        if ($pron == null) {
            return response()->json([

                'mensaje' => 'No se encontro el pronostico'
            ], 404);
        }
        $pron->update($input);
        return $pron;
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
        $pron = Pronostio::find($id);
        if ($pron == null) {
            return response()->json([

                'mensaje' => 'No se encontro el pronostico'
            ], 404);
        }
        $pron->delete();
        return $pron;
    }
}
