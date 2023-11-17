<?php

namespace Database\Factories;

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
            'nombres' => fake()->firstName(),
            'apellidos' => fake()->lastName(),
            'codigo_cliente' => fake()->creditCardNumber(),
        ];
    }
}
