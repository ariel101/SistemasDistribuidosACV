<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use App\Models\Cliente;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Cuenta>
 */
class CuentaFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        $cliente_id =Cliente::inRandomOrder()->first()->id;
        $moneda = ['BOB','SUS','EU'];
        return [
            //
            // 'nro_cuenta' => fake()->randomNumber(2,10),
            // 'cliente_id' => fake()->randomNumber(2,10),
            // 'saldo' => fake()->randomFloat(2,10,1000),
            // 'moneda' => fake()->randomLetter(),
        ];
    }
}
