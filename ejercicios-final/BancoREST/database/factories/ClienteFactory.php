<?php

namespace Database\Factories;

use App\Models\Cliente;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Cliente>
 */
class ClienteFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        
        return [
            //
            'ci' => $this->faker->unique()->randomNumber(8),
            'nombres' => fake()->name(),
            'apellidos' => fake()->lastName(),
            'codigo_cliente' => fake()->creditCardNumber(),
        ];
    }
}
