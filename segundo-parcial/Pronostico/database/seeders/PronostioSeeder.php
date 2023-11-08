<?php

namespace Database\Seeders;

use App\Models\Pronostio;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class PronostioSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        //
            Pronostio::create([
                'fecha'=>'04-02-21',
                'temperatura' => '21',
                'probabilidad' => '36,74%'
            ]);
    
            Pronostio::create([
                'fecha'=>'05-02-21',
                'temperatura' => '22',
                'probabilidad' => '80%',
            ]);

            Pronostio::create([
                'fecha'=>'06-02-21',
                'temperatura' => '25',
                'probabilidad' => '1,26%',
            ]);
    
            Pronostio::create([
                'fecha'=>'07-02-21',
                'temperatura' => '26',
                'probabilidad' => '0,42%',
            ]);
            Pronostio::create([
                'fecha'=>'08-02-21',
                'temperatura' => '28',
                'probabilidad' => '46,85%',
            ]);
    
            Pronostio::create([
                'fecha'=>'09-02-21',
                'temperatura' => '19',
                'probabilidad' => '4,21%',
            ]);
            Pronostio::create([
                'fecha'=>'10-02-21',
                'temperatura' => '22',
                'probabilidad' => '8,79%',
            ]);
    
            Pronostio::create([
                'fecha'=>'11-02-21',
                'temperatura' => '12',
                'probabilidad' => '0,69%',
            ]);

            Pronostio::create([
                'fecha'=>'12-02-21',
                'temperatura' => '18',
                'probabilidad' => '0,65%',
            ]);
    }
}

