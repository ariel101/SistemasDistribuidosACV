<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Cuenta extends Model
{
    use HasFactory;
    protected $fillable=[
        'nro_cuenta',
        'cliente_id',
        'saldo',
        'moneda'];
}
