<?php

namespace Database\Seeders;

use App\Models\Cuenta;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class CuentaSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        //
        //Cuenta::factory(4)->create();

        Cuenta::create([
            'nro_cuenta'=>'2374931323',
            'cliente_id'=>'3',
            'saldo'=>'4500',
            'moneda'=>'SUS'
        ]);

        Cuenta::create([
            'nro_cuenta'=>'2334349332',
            'cliente_id'=>'1',
            'saldo'=>'45000',
            'moneda'=>'BOB'
        ]);

        Cuenta::create([
            'nro_cuenta'=>'1293400224',
            'cliente_id'=>'2',
            'saldo'=>'400',
            'moneda'=>'EU'
        ]);

        Cuenta::create([
            'nro_cuenta'=>'1399993321',
            'cliente_id'=>'4',
            'saldo'=>'5000',
            'moneda'=>'SUS'
        ]);
    }
}
