<?php

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Pronostio>
 */
class PronostioFactory extends Factory
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
            'fecha' => $this->faker->date,
            'temperatura' => $this->faker->randomFloat(2, -10, 40),  // Genera temperaturas entre -10 y 40 grados Celsius
            'probabilidad' => $this->faker->randomFloat(2, 0, 100),  
        ];
    }
}
